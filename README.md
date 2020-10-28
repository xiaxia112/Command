# Command

__A simple text editor by Command pattern and Memento pattern__

具体实现类图在[ClassGraph.puml](./ClassGraph.puml)中
命令响应主要通过Command接口及其一系列实现类来实现，由main()调用Switch，
Switch从hashmap中选出对应指令对象，再通过Command的统一接口函数execute()来完成对命令的执行，
命令的具体执行函数由运行时的具体command来完成

而redo及undo的实现，则通过备忘录模式实现，
每一次修改命令执行完毕后都会再switch的stateNodesList中留下存有命令Command内容与修改后的文本内容s的记录，
在之后的redo\undo操作时，直接获取之前的状态进行重载

对于宏命令，同样也是在stateNodesList中提取对应若干stateNode中记录的Command，
储存为一个数组，在后续调用宏命令时，顺序执行数组中Command即可
