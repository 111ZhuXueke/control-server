package com.rui.web.common.enums;

import java.awt.event.KeyEvent;

/**
 * 键盘值
 * @author : zhuxueke
 * @since : 2018-01-26 9:52
 **/
public enum Keyboard {
    A(65,"键盘值 A","a"),
    B(66,"键盘值 B","b"),
    C(67,"键盘值 C","c"),
    D(68,"键盘值 D","d"),
    E(69,"键盘值 E","e"),
    F(70,"键盘值 F","f"),
    G(71,"键盘值 G","g"),
    H(72,"键盘值 H","h"),
    I(73,"键盘值 I","i"),
    J(74,"键盘值 J","j"),
    K(75,"键盘值 K","k"),
    L(76,"键盘值 L","l"),
    M(77,"键盘值 M","m"),
    N(78,"键盘值 N","n"),
    O(79,"键盘值 O","o"),
    P(80,"键盘值 P","p"),
    Q(81,"键盘值 Q","q"),
    R(82,"键盘值 R","r"),
    S(83,"键盘值 S","s"),
    T(84,"键盘值 T","t"),
    U(85,"键盘值 U","u"),
    V(86,"键盘值 V","v"),
    W(87,"键盘值 W","w"),
    X(88,"键盘值 X","x"),
    Y(89,"键盘值 Y","y"),
    Z(90,"键盘值 Z","z"),
    CTRL(17,"键盘值 Ctrl","ctrl"),
    SHIFT(16,"键盘值 Shift","shift"),
    ALT(18,"键盘值 Alt","alt"),
    WINDOW(524,"键盘值 WINDOW","window"),
    BACKSPACE(8,"键盘值 Backspace","backspace"),
    ENTER(10,"键盘值 Enter","enter"),
    UP(38,"方向键 上","up"),
    DOWN(40,"方向键 下","down"),
    LEFT(37,"方向键 左","left"),
    RIGHT(39,"方向键 右","right");

    private int value;
    private String description;
    private String keyName;
    /**
     * 构造枚举属性的结构
     * @author : zhuxueke
     * @since : 2018/1/26 10:34
     */
    Keyboard(int value, String description,String keyName){
        this.value = value;
        this.description = description;
        this.keyName = keyName;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public String getKeyName() {
        return keyName;
    }

    public static void main(String[] args){
        System.out.println(KeyEvent.VK_A);
        System.out.println(KeyEvent.VK_B);
        System.out.println(KeyEvent.VK_C);
        System.out.println(KeyEvent.VK_D);
        System.out.println(KeyEvent.VK_E);
        System.out.println(KeyEvent.VK_F);
        System.out.println(KeyEvent.VK_G);
        System.out.println(KeyEvent.VK_H);
        System.out.println(KeyEvent.VK_I);
        System.out.println(KeyEvent.VK_J);
        System.out.println(KeyEvent.VK_K);
        System.out.println(KeyEvent.VK_L);
        System.out.println(KeyEvent.VK_M);
        System.out.println(KeyEvent.VK_N);
        System.out.println(KeyEvent.VK_O);
        System.out.println(KeyEvent.VK_P);
        System.out.println(KeyEvent.VK_Q);
        System.out.println(KeyEvent.VK_R);
        System.out.println(KeyEvent.VK_S);
        System.out.println(KeyEvent.VK_T);
        System.out.println(KeyEvent.VK_U);
        System.out.println(KeyEvent.VK_V);
        System.out.println(KeyEvent.VK_W);
        System.out.println(KeyEvent.VK_X);
        System.out.println(KeyEvent.VK_Y);
        System.out.println(KeyEvent.VK_Z);
        System.out.println(KeyEvent.VK_CONTROL);
        System.out.println(KeyEvent.VK_SHIFT);
        System.out.println(KeyEvent.VK_ALT);
        System.out.println(KeyEvent.VK_WINDOWS);
        System.out.println(KeyEvent.VK_BACK_SPACE);
        System.out.println(KeyEvent.VK_ENTER);
        System.out.println(KeyEvent.VK_UP);
        System.out.println(KeyEvent.VK_DOWN);
        System.out.println(KeyEvent.VK_LEFT);
        System.out.println(KeyEvent.VK_RIGHT);
    }
}
