public class ArrayVectorImpl implements ArrayVector{

    public double[] array;

    public ArrayVectorImpl() {
    }

    public ArrayVectorImpl(double[] array) {
        this.array = array;
    }

    @Override
    public void set(double... elements) {

        array = new double[elements.length];
        System.arraycopy(elements, 0, array, 0, elements.length);
    }

    @Override
    public double[] get() {

        return array;
    }

    @Override
    public ArrayVector clone() {
        return new ArrayVectorImpl(array.clone());
    }

    @Override
    public int getSize() {
        return array.length;
    }

    @Override
    public void set(int index, double value) {

        if(index < 0)
            return;

        else if(index >= array.length) {

            double[] NewArray = array.clone();
            array = new double[index + 1];
            for(int i = 0; i < NewArray.length; i++)
                array[i] = NewArray[i];
            array[index] = value;
        }

        else
            array[index] = value;
    }

    @Override
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        return array[index];
    }

    @Override
    public double getMax() {

        double max = Double.MIN_VALUE + 1;
        for(int index = 0; index < array.length; index++)
            if(array[index] > max)
                max = array[index];

        return max;
    }

    @Override
    public double getMin() {

        double min = Double.MAX_VALUE - 1;
        for(int index = 0; index < array.length; index++)
            if(array[index] < min)
                min = array[index];

        return min;
    }

    @Override
    public void sortAscending() {

        for (int j = 0; j < array.length; j++) {

            int minInd = j;
            for (int i = j; i < array.length; i++)
                if (array[i] < array[minInd])
                    minInd = i;

            double tmp = array[j];
            array[j] = array[minInd];
            array[minInd] = tmp;
        }
    }

    @Override
    public void mult(double factor) {

        for(int index = 0; index < array.length; index++)
            array[index] *= factor;
    }

    @Override
    public ArrayVector sum(ArrayVector anotherVector) {

        int size = (array.length > anotherVector.getSize()) ? array.length : anotherVector.getSize();
        for(int index = 0; index < size; index++)
            array[index] += anotherVector.get(index);
        return this;
    }

    @Override
    public double scalarMult(ArrayVector anotherVector) {

        double meaning = 0;
        int size = (array.length > anotherVector.getSize()) ? array.length : anotherVector.getSize();
        for(int index = 0; index < size; index++)
            meaning += array[index] * anotherVector.get(index);

        return meaning;
    }

    @Override
    public double getNorm() {
        return Math.sqrt(scalarMult(new ArrayVectorImpl(array)));
    }
}
