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
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.Bullet;
import com.badlogic.gdx.physics.bullet.collision.Collision;
import com.badlogic.gdx.physics.bullet.collision.CollisionObjectWrapper;
import com.badlogic.gdx.physics.bullet.collision.btBoxShape;
import com.badlogic.gdx.physics.bullet.collision.btCollisionAlgorithm;
import com.badlogic.gdx.physics.bullet.collision.btCollisionAlgorithmConstructionInfo;
import com.badlogic.gdx.physics.bullet.collision.btCollisionConfiguration;
import com.badlogic.gdx.physics.bullet.collision.btCollisionDispatcher;
import com.badlogic.gdx.physics.bullet.collision.btCollisionObject;
import com.badlogic.gdx.physics.bullet.collision.btCollisionShape;
import com.badlogic.gdx.physics.bullet.collision.btDefaultCollisionConfiguration;
import com.badlogic.gdx.physics.bullet.collision.btDispatcher;
import com.badlogic.gdx.physics.bullet.collision.btDispatcherInfo;
import com.badlogic.gdx.physics.bullet.collision.btManifoldResult;
import com.badlogic.gdx.physics.bullet.collision.btSphereBoxCollisionAlgorithm;
import com.badlogic.gdx.physics.bullet.collision.btSphereShape;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Physics_1st implements ApplicationListener {

    public PerspectiveCamera camera;
    public Model model;
    public ArrayList<ModelInstance> instances;
    public ModelBatch batch;
    public Environment environment;
    public CameraInputController controller;
    public ModelInstance ball, cube;





    btCollisionShape groundShape;
    btCollisionShape ballShape, cubeShape;
    btCollisionObject groundObject;
    btCollisionObject ballObject, cubeObject;
    btCollisionConfiguration collisionConfig;
    btDispatcher dispatcher;
    boolean collision;
    float speed = 0f;

    @Override
    public void create() {





        Bullet.init();
//        collision = false;



        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight,
                0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

        batch = new ModelBatch();

        camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(10, 10, 10);
        camera.lookAt(0, 0, 0);
        camera.near =  1;
        camera.far = 300;
        camera.update();

//        ModelBuilder builder = new ModelBuilder();
//        model = builder.createSphere(5f, 5f, 5f,500,20,
//                new Material(ColorAttribute.createDiffuse(Color.GREEN)),
//                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal
//                );
//        instance = new ModelInstance(model);




        ModelBuilder builder = new ModelBuilder();
        builder.begin();
        builder.node().id = "ground";
        builder.part("box", GL20.GL_TRIANGLES,
                        VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal,
                        new Material(ColorAttribute.createDiffuse(Color.RED)))
                .box(15f, 1f, 5f);

        builder.node().id = "ball";
        builder.part("sphere", GL20.GL_TRIANGLES,
                        VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal,
                        new Material(ColorAttribute.createDiffuse(Color.GREEN)))
                .sphere(1f, 1f, 1f, 10, 10);

        builder.node().id = "cube";
        builder.part("box", GL20.GL_TRIANGLES,
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal,
                new Material(ColorAttribute.createDiffuse(Color.ORANGE)))
                .box(1f, 1f, 1f);

        model = builder.end();
        instances = new ArrayList<>();

        ModelInstance ground = new ModelInstance(model, "ground");
        instances.add(ground);
//
        ball = new ModelInstance(model, "ball");
        ball.transform.setToTranslation(0f, 5f, 0f);
        instances.add(ball);
//
//        cube = new ModelInstance(model, "cube");
//        cube.transform.setToTranslation(-7f, 4f, 1f);
//        instances.add(cube);

        controller = new CameraInputController(camera);
        Gdx.input.setInputProcessor(controller);





        ballShape    = new btSphereShape(0.5f);
        groundShape  = new btBoxShape(new Vector3(7.5f, 0.5f, 2.5f));
//        cubeShape    = new btBoxShape(new Vector3(0.5f, 0.5f, 0.5f));
//
        groundObject = new btCollisionObject();
        groundObject.setCollisionShape(groundShape);
        groundObject.setWorldTransform(ground.transform);
//
        ballObject = new btCollisionObject();
        ballObject.setCollisionShape(ballShape);
        ballObject.setWorldTransform(ball.transform);
//
//        cubeObject = new btCollisionObject();
//        cubeObject.setCollisionShape(cubeShape);
//        cubeObject.setWorldTransform(cube.transform);
//


        collisionConfig = new btDefaultCollisionConfiguration();
        dispatcher = new btCollisionDispatcher(collisionConfig);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {

//        final float delta = Math.min(1f/30f, Gdx.graphics.getDeltaTime());

        if(!collision) {
            ball.transform.translate(0f, speed, 0f);
            ballObject.setWorldTransform(ball.transform);
            collision = Moving();
            speed -= 0.01f;

//            cube.transform.translate(0.1f, speed, 0f);
//            cubeObject.setWorldTransform(cube.transform);
//            collision = AnyToAnyMoving(groundObject, cubeObject);
//            speed -= 0.01f;
        }

        else {
            collision = false;
            speed = -speed;
        }

        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        batch.begin(camera);
        batch.render(instances, environment);
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

//        groundObject.dispose();
//        ballObject.dispose();
//        groundShape.dispose();
//        ballShape.dispose();

        dispatcher.dispose();
        collisionConfig.dispose();
    }

    private boolean Moving() {

        CollisionObjectWrapper co0 = new CollisionObjectWrapper(ballObject);
        CollisionObjectWrapper co1 = new CollisionObjectWrapper(groundObject);

        btCollisionAlgorithmConstructionInfo ci = new btCollisionAlgorithmConstructionInfo();
        ci.setDispatcher1(dispatcher);
        btCollisionAlgorithm algorithm = new btSphereBoxCollisionAlgorithm(null, ci, co0.wrapper, co1.wrapper, false);

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

    private boolean AnyToAnyMoving(btCollisionObject object1, btCollisionObject object2) {

        CollisionObjectWrapper co0 = new CollisionObjectWrapper(object1);
        CollisionObjectWrapper co1 = new CollisionObjectWrapper(object2);

        btCollisionAlgorithmConstructionInfo ci = new btCollisionAlgorithmConstructionInfo();
        ci.setDispatcher1(dispatcher);
//        btCollisionAlgorithm algorithm = new btSphereBoxCollisionAlgorithm(null, ci, co0.wrapper, co1.wrapper, false);
        btCollisionAlgorithm algorithm = dispatcher.findAlgorithm(co0.wrapper, co1.wrapper, null, 0);

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
}
