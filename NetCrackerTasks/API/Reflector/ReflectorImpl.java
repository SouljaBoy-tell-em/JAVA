import java.lang.reflect.*;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

public class ReflectorImpl implements Reflector{

    Class<?> clazz;

    @Override
    public void setClass(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Stream<String> getMethodNames(Class<?>... paramTypes) {
        if (clazz == null) {
            throw new NullPointerException();
        }

        Set<String> methodNames = new HashSet<>();
        getMethodNamesRecursive(clazz, paramTypes, methodNames);
        return methodNames.stream();
    }

    private void getMethodNamesRecursive(Class<?> currentClass, Class<?>[] paramTypes, Set<String> methodNames) {
        if (currentClass == null) {
            return;
        }

        for (Method method : currentClass.getDeclaredMethods()) {
            if (isPublic(method) && hasMatchingParams(method, paramTypes)) {
                methodNames.add(method.getName());
            }
        }

        getMethodNamesRecursive(currentClass.getSuperclass(), paramTypes, methodNames);
    }

    private boolean isPublic(Method method) {
        return (method.getModifiers() & java.lang.reflect.Modifier.PUBLIC) != 0;
    }

    private boolean hasMatchingParams(Method method, Class<?>[] paramTypes) {
        Class<?>[] methodParamTypes = method.getParameterTypes();

        if (paramTypes.length != methodParamTypes.length) {
            return false;
        }

        for (int i = 0; i < paramTypes.length; i++) {
            if (!methodParamTypes[i].equals(paramTypes[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Stream<Field> getAllDeclaredFields() {
        if (clazz == null) {
            throw new NullPointerException();
        }

        return getAllFields(clazz);
    }

    private Stream<Field> getAllFields(Class<?> currentClass) {
        if (currentClass == null) {
            return Stream.empty();
        }

        Stream<Field> fields = Stream.of(currentClass.getDeclaredFields())
                .filter(field -> !java.lang.reflect.Modifier.isStatic(field.getModifiers()));

        Stream<Field> superClassFields = getAllFields(currentClass.getSuperclass());

        return Stream.concat(fields, superClassFields);
    }


    @Override
    public Object getFieldValue(Object target, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        if (target == null) {
            throw new NullPointerException();
        }

        Class<?> currentClass = (clazz != null) ? clazz : target.getClass();
        Field field = getField(currentClass, fieldName);

        if (field == null) {
            throw new NoSuchFieldException();
        }

        field.setAccessible(true);
        return field.get(target);
    }

    private Field getField(Class<?> currentClass, String fieldName) {
        try {
            return currentClass.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            if (currentClass.getSuperclass() != null) {
                return getField(currentClass.getSuperclass(), fieldName);
            }
            return null;
        }
    }


    @Override
    public Object getMethodResult(Object constructorParam, String methodName, Object... methodParams)
            throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if (clazz == null) {
            throw new NullPointerException();
        }

        Object instance;
        if (constructorParam != null) {
            Constructor<?> constructor = clazz.getConstructor(constructorParam.getClass());
            instance = constructor.newInstance(constructorParam);
        } else {
            instance = clazz.newInstance();
        }

        Method method = findMethod(instance.getClass(), methodName, methodParams);
        return method.invoke(instance, methodParams);
    }

    private Method findMethod(Class<?> currentClass, String methodName, Object[] methodParams)
            throws NoSuchMethodException {
        if (currentClass == null) {
            throw new NoSuchMethodException();
        }

        Class<?>[] paramTypes = new Class<?>[methodParams.length];
        for (int i = 0; i < methodParams.length; i++) {
            paramTypes[i] = methodParams[i].getClass();
        }

        try {
            return currentClass.getDeclaredMethod(methodName, paramTypes);
        } catch (NoSuchMethodException e) {
            return findMethod(currentClass.getSuperclass(), methodName, methodParams);
        }
    }

}
