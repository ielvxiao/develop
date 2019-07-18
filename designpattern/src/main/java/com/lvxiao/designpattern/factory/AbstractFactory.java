package com.lvxiao.designpattern.factory;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-18 14:20
 */
interface Play{
    void play();
}
interface Song{
    void sing();
}
class AndroidPlay implements Play{

    @Override
    public void play() {
        System.out.println("android play");
    }
}
class AndroidSong implements Song{

    @Override
    public void sing() {
        System.out.println("android sing");
    }
}

class IOSPlay implements Play{

    @Override
    public void play() {
        System.out.println("IOS play");
    }
}
class IOSSong implements Song{

    @Override
    public void sing() {
        System.out.println("IOS sing");
    }
}

interface SystemOperate{
    Play getPlay();
    Song getSong();
}

class IOSSystemOperate implements SystemOperate {

    @Override
    public Play getPlay() {
        return new IOSPlay();
    }

    @Override
    public Song getSong() {
        return new IOSSong();
    }
}

class AndroidSystemOperate implements SystemOperate {

    @Override
    public Play getPlay() {
        return new AndroidPlay();
    }

    @Override
    public Song getSong() {
        return new AndroidSong();
    }
}
public class AbstractFactory {
    public static void main(String[] args) {
        SystemOperate operate = new AndroidSystemOperate();
        operate.getPlay().play();
    }
}
