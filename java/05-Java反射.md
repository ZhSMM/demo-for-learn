# Java反射

反射的实质：由对象实例获取对象的java.lang.Class对象。

反射的源头：java.lang.Object方法  `public final native Class<?> getClass();`

### 类加载

加载(Loading)指的是将类的class文件读入到内存，并为之创建一个java.lang.Class对象，也就是说，

- 当程序中使用任何类时，系统都会为之建立一个java.lang.Class对象；
- 一旦一个类被加载到 JVM 中，同一个类就不会被再次载入了；
- 就像一个对象有一个唯一的标识一样，一个载入JVM的类也有一个唯一的标识；
  - 在 Java 中，一个类用其**全限定类名（包括包名和类名）**作为标识；
  - 在 JVM 中，一个类用其全限定类名和其类加载器作为其唯一标识；

### 获取Class对象的方式

```java
public class DemoGetClass {
    public static void main(String[] args) {
        // 1. 创建一个User实例，获取其Class对象
        Class<? extends User> c1 = new User().getClass();
        // 2. 直接通过类对象获取
        Class<User> c2 = User.class;
        // 3. 通过类加载器获取
        Class<?> c3 =null;
        try {
            c3=Class.forName("org.example.entity.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 4.验证这三个Class对象是否为同一Class对象
        System.out.println("c1："+c1.hashCode());   // 1670675563
        System.out.println("c2："+c2.hashCode());   // 1670675563
        assert c3 != null;
        System.out.println("c3："+c3.hashCode());   // 1670675563

        // 5.获取这个Class实例的加载器
        ClassLoader loader=c1.getClassLoader();
        System.out.println("User类的类加载器："+loader);  // sun.misc.Launcher$AppClassLoader@18b4aac2

        // 6.类加载器的父类以及父类
        System.out.println("User类加载器父类："+loader.getParent());  // sun.misc.Launcher$ExtClassLoader@2b193f2d
        System.out.println("User类加载器父类的父类："+loader.getParent().getParent());  // null

        // 7.Object类的类加载器
        System.out.println("Object类的类加载器:"+Object.class.getClassLoader());  // null

        // 8.int、float、boolean以及Integer、String等的类加载器
        //    均为null  ,即基本类型及其包装类 是由BootStrapClassLoader加载器加载
        System.out.println("int:"+int.class.getClassLoader());
        System.out.println("float:"+float.class.getClassLoader());
        System.out.println("boolean:"+boolean.class.getClassLoader());
        System.out.println("String:"+String.class.getClassLoader());
        System.out.println("Integer:"+Integer.class.getClassLoader());
        System.out.println("Boolean:"+Boolean.class.getClassLoader());
        System.out.println("Float:"+Float.class.getClassLoader());
    }
}
```

### 创建实例

```java
public class DemoNewInstance {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // 获取Class实例
        Class<User> userClass = User.class;
        // 1. 通过Class实例无参构造创建实例
        User user1=userClass.newInstance();
        System.out.println(user1);

        // 2. 通过构造器创建实例
        Constructor<User> constructor = userClass.getConstructor(null);
        User user=constructor.newInstance();
        System.out.println(user);
    }
}
```

### 获取方法、字段

```java
public class DemoReflect {

    // 获取属性
    public static void TestField(Class<?> clazz){
        // 1. Class.getFields():获得某个类的所有的公共（public）的字段，包括父类中的字段。
        Field[] fields=clazz.getFields();

        // 2. Class.getDeclaredFields():获得某个类的所有声明的字段，即包括public、private和proteced，但是不包括父类的申明字段。
        Field[] declaredFields=clazz.getDeclaredFields();

        for (Field field : fields) {
            System.out.println("getFields()方法:"+field);
        }
        for (Field declaredField : declaredFields) {
            System.out.println("getDeclaredFields()方法:"+declaredField);
        }
    }
    // 获取方法
    public static void TestMethod(Class<?> clazz){
        // 1. Class.getMethods():该方法是获取本类以及父类或者父接口中所有的公共方法(public修饰符修饰的)
        Method[] methods=clazz.getMethods();

        // 2. Class.getDeclaredFields():方法是获取本类中的所有方法，包括私有的(private、protected、默认以及public)的方法。
        Method[] declaredMethods=clazz.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println("getMethod()方法:"+method);
        }
        for (Method declaredMethod : declaredMethods) {
            System.out.println("getDeclaredMethod()方法："+declaredMethod);
        }
    }
    // 获取构造方法
    public static void TestConstructor(Class<?> clazz){
        // 获取所有构造函数
        Constructor<?>[] constructors=clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            if (constructor.getParameterTypes().length == 0){
                System.out.println(clazz.getName()+"的无参构造函数："+constructor);
            }else{
                System.out.println(clazz.getName()+"的有参构造函数："+constructor);
            }
        }
        // 获取无参构造函数
        Constructor<?> constructor =null;
        try {
             constructor=clazz.getConstructor(null);
            System.out.println(clazz.getSimpleName()+"的无参构造："+constructor);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    // 获取父类
    public static void TestParent(Class<?> clazz){
        // 得到接口
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("接口："+anInterface);
        }
        // 得到父类
        Class<?> superclass = clazz.getSuperclass();
        System.out.println("父类："+superclass);
    }
    public static void main(String[] args) {
        TestField(User.class);
        TestMethod(User.class);
        TestConstructor(User.class);
        TestParent(People.class);
    }
}
```

### 字段与方法

```java
/**
 * 1. 获取字段的名称： String fieldName = field.getName();
 * 2. 获取字段的修饰符：int fieldValue = field.getModifiers(); //如：private、static、final等
 * 3. 与某个具体的修饰符进行比较：Modifier.isStatic(fieldValue) //看此修饰符是否为静态(static)
 * 4. 获取字段的声明类型：field.getType()；//返回的是一个class
 * 5. 与某个类型进行比较：field.getType() == Timestamp.class
 * 6. 获取指定对象中此字段的值：Object fieldObject= field.get(user);//user可以看做是从数据库中查找出来的对象
 **/
public class DemoField {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        // 1. 通过反射获取Class对象
        Class<User> user = User.class;
        // 2. 获取属性
        Field[] fields = user.getDeclaredFields();
        // 3. 获取字段名称
        Field id = null;
        for (Field field : fields) {
            if ("id".equals(field.getName())){
                id=field;
            }
        }
        // 4. 获取属性的修饰符
        assert id != null;
        int modifiers = id.getModifiers();
        System.out.println(id.getName()+"的修饰符："+modifiers);
        // 5. 与某个具体的修饰符进行比较：Modifier.isStatic(fieldValue)
        System.out.println(Modifier.isStatic(modifiers)+" "+Modifier.isPrivate(modifiers));
        // 6. 获取字段的声明类型：field.getType()；
        Class<?> type = id.getType();
        System.out.println("id的类型：" + type);
        // 7. 设置属性
        // 8. 接触验证，对私有属性设置时需要
        if (!id.isAccessible()){
            id.setAccessible(true);  // 默认false，需要进行验证 ；true，不需要验证
        }
        // 9.创建user实例
        User user1 = user.newInstance();
        // 设置属性值
        id.set(user1,10);
        // 得到属性值
        System.out.println(id.get(user1));
    }
}
```

```java
public class DemoMethod {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<User> userClass = User.class;
        Method setId = userClass.getDeclaredMethod("setId", Integer.class);
        User user=userClass.newInstance();
        setId.invoke(user,18);

        Method hello=userClass.getDeclaredMethod("hello");
        hello.setAccessible(true);  // 私有方法需要解除验证
        hello.invoke(user);

        System.out.println(user);
    }
}
```