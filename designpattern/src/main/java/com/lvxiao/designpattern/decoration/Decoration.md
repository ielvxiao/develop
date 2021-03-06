# 继承
继承是给一个类添加行为的比较有效的途径。通过使用继承，可以使得子类在拥有自身方法的同时，还可以拥有父类的方法。但是使用继承是静态的，在**编译**的时候就已经决定了子类的行为，我们不便于控制增加行为的方式和时机。
# 装饰器的优势
1、装饰者模式可以提供比继承更多的灵活性

2、可以通过一种动态的方式来扩展一个对象的功能，在**运行**时选择不同的装饰器，从而实现不同的行为。

3、通过使用不同的具体装饰类以及这些装饰类的排列组合，可以创造出很多不同行为的组合。可以使用多个具体装饰类来装饰同一对象，得到功能更为强大的对象。

4、具体构件类与具体装饰类可以独立变化，用户可以根据需要增加新的具体构件类和具体装饰类，在使用时再对其进行组合，原有代码无须改变，符合“开闭原则”。