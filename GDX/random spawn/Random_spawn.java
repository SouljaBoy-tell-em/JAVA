package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.Bullet;
import com.badlogic.gdx.physics.bullet.collision.CollisionObjectWrapper;
import com.badlogic.gdx.physics.bullet.collision.btBoxShape;
import com.badlogic.gdx.physics.bullet.collision.btCollisionAlgorithm;
import com.badlogic.gdx.physics.bullet.collision.btCollisionAlgorithmConstructionInfo;
import com.badlogic.gdx.physics.bullet.collision.btCollisionConfiguration;
import com.badlogic.gdx.physics.bullet.collision.btCollisionDispatcher;
import com.badlogic.gdx.physics.bullet.collision.btCollisionObject;
import com.badlogic.gdx.physics.bullet.collision.btCollisionShape;
import com.badlogic.gdx.physics.bullet.collision.btConeShape;
import com.badlogic.gdx.physics.bullet.collision.btCylinderShape;
import com.badlogic.gdx.physics.bullet.collision.btDefaultCollisionConfiguration;
import com.badlogic.gdx.physics.bullet.collision.btDispatcher;
import com.badlogic.gdx.physics.bullet.collision.btDispatcherInfo;
import com.badlogic.gdx.physics.bullet.collision.btManifoldResult;
import com.badlogic.gdx.physics.bullet.collision.btSphereBoxCollisionAlgorithm;
import com.badlogic.gdx.physics.bullet.collision.btSphereShape;

import java.util.ArrayList;
import java.util.HashMap;

import jdk.internal.net.http.common.Log;

public class Physics_1st implements ApplicationListener {
    private PerspectiveCamera camera;
    private Model model;
    private ArrayList<String> nodesId;
    private HashMap<String, btCollisionShape> ShapeCreator;
    private ModelBatch batch;
    private Environment environment;
    private CameraInputController controller;
    private btCollisionShape groundShape;
    private btCollisionObject groundObject;
    private btCollisionConfiguration collisionConfig;
    private btDispatcher dispatcher;
    private float spawnTimer;
    public ArrayList<GameObject> objects;
    public ModelInstance ground;
    private String[] params = {"cube", /*"ball",*/ /*"cube",*/ /*"cylinder",*/ /*"ball",*/ "par"};
    private ModelBuilder builder;

    @Override
    public void create() {

        spawnTimer = 3.5f;
        Bullet.init();
        environment = new Environment();
        ShapeCreator = new HashMap<>();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight,
                0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f,
                                          -1f, -0.8f, -0.2f));
        batch = new ModelBatch();
        camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(),
                                                    Gdx.graphics.getHeight());
        camera.position.set(10, 10, 10);
        camera.lookAt(0, 0, 0);
        camera.near =  1;
        camera.far = 300;
        camera.update();

        builder = new ModelBuilder();
        nodesId = new ArrayList<>();
        builder.begin();
        builder.node().id = "ground";
        builder.part("box", GL20.GL_TRIANGLES,
                        VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal,
                        new Material(ColorAttribute.createDiffuse(Color.RED)))
               .box(15f, 1f, 15f);
        CreateNode("ball", "sphere",
                new Material(ColorAttribute.createDiffuse(Color.GREEN)),
                new btSphereShape(0.5f))
                .sphere(1f, 1f, 1f, 10, 10);
        CreateNode("cube", "cube",
                new Material(ColorAttribute.createDiffuse(Color.PINK)),
                new btBoxShape(new Vector3(0.5f, 0.5f, 0.5f)))
                .box(1f, 1f, 1f);
        CreateNode("par", "cube",
                new Material(ColorAttribute.createDiffuse(Color.VIOLET)),
                new btBoxShape(new Vector3(1.5f, 1f, 0.5f)))
                .box(3f, 2f, 1f);
//        CreateNode("cylinder", "cylinder",
//                new Material(ColorAttribute.createDiffuse(Color.CYAN)),
//                new btCylinderShape(new Vector3(.5f, 1f, .5f)))
//                .cylinder(1f, 2f, 1f, 10);
        model = builder.end();

        ground = new ModelInstance(model, "ground");
        groundShape = new btBoxShape(new Vector3(7.5f, 0.5f, 7.5f));
        groundObject = new btCollisionObject();
        groundObject.setCollisionShape(groundShape);
        groundObject.setWorldTransform(ground.transform);
        objects = new ArrayList<>();
        objects.add(new GameObject(model, "cube",
                new Vector3(0f, 9f, 0f), new btBoxShape(new Vector3(0.5f, 0.5f, 0.5f))));
//        objects.add(new GameObject(model, "cone",
//                new Vector3(0f, 9f, 0f), new btConeShape(0.5f, 2f)));

        controller = new CameraInputController(camera);
        Gdx.input.setInputProcessor(controller);
        collisionConfig = new btDefaultCollisionConfiguration();
        dispatcher = new btCollisionDispatcher(collisionConfig);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {

        final float delta = 0.01f;

        Spawn(delta);

        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        batch.begin(camera);
        batch.render(ground, environment);
        batch.render(objects, environment);
        batch.end();

        controller.update();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        model.dispose();

        groundObject.dispose();
        groundShape.dispose();

        dispatcher.dispose();
        collisionConfig.dispose();

        for(GameObject object : objects)
            object.btCollisionObject.dispose();
        objects.clear();
    }

    private boolean AnyToAnyMoving(btCollisionObject object1, btCollisionObject object2) {

        CollisionObjectWrapper co0 = new CollisionObjectWrapper(object1);
        CollisionObjectWrapper co1 = new CollisionObjectWrapper(object2);
        btCollisionAlgorithmConstructionInfo ci = new btCollisionAlgorithmConstructionInfo();
        ci.setDispatcher1(dispatcher);
        btCollisionAlgorithm algorithm = dispatcher.findAlgorithm(co0.wrapper,
                                 co1.wrapper, null, 0);
        btDispatcherInfo info = new btDispatcherInfo();
        btManifoldResult result = new btManifoldResult(co0.wrapper, co1.wrapper);
        algorithm.processCollision(co0.wrapper, co1.wrapper, info, result);
        boolean r = result.getPersistentManifold().getNumContacts() > 0;

        result.dispose();
        info.dispose();
        algorithm.dispose();
        ci.dispose();
        co1.dispose();
        co0.dispose();

        return r;
    }

    private MeshPartBuilder CreateNode(String nodeId, String type, Material material,
                                       btCollisionShape shape) {
        builder.node().id = nodeId;
        nodesId.add(type);
        ShapeCreator.put(nodeId, shape);
        return builder.part(nodeId, GL20.GL_TRIANGLES,
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal,
               material);
    }

    private void Spawn(float delta) {

        int LastIndex = objects.size() - 1;
        if(!objects.get(LastIndex).collision) {
            delta += 0.1f;
            objects.get(LastIndex).transform.translate(0f, -delta, 0f);
            objects.get(LastIndex).btCollisionObject.setWorldTransform(objects.get(LastIndex).transform);
            if(AnyToAnyMoving(groundObject, objects.get(LastIndex).btCollisionObject)) {
                objects.get(LastIndex).collision = true;
                GameObject object = new GameObject(model, params[(int) (Math.random() * params.length)],
                        new Vector3(rnd(-3f, 3f), 9f, rnd(-3f, 3f)),
                        ShapeCreator.get(params[(int) (Math.random() * params.length)]));
                objects.add(object);
            }
        }

        if((spawnTimer -= delta) < 0)
            spawnTimer = 0.5f;
    }

    private float rnd(float min, float max) {
        return (float) (Math.random() * 7f - 3f);
    }
}
