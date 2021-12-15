package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Pokemon {
    private String name;
    private String nickname;
    private String type;
    private int maxPV;
    private int currentPV;
    private HashMap<String, Integer> attacks = new HashMap<>(4);

    public void init(String name, String type, int maxPV){
        setName(name);
        setType(type);
        setMaxPV(maxPV);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void askNickname(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What nickname do you want to give to "+ name +"?");
        String saisie = sc.nextLine();
        setNickname(saisie);
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setMaxPV(int maxPV) {
        this.maxPV = maxPV;
    }

    public int getMaxPV() {
        return maxPV;
    }

    public void initCurrentPV(){
        this.currentPV = maxPV;
    }

    public void setCurrentPV(int currentPV) {
        this.currentPV = currentPV;
    }

    public int getCurrentPV() {
        return currentPV;
    }

    public int askAttack(){
        int value = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Whick attack do you choose?");
        int i = 0;
        for (String key : this.attacks.keySet()){
            System.out.println(i + ": " + key + " — Damage: " + this.attacks.get(key));
            i+=1;
        }
        int saisie;
        do{
            saisie = sc.nextInt();
        }while(saisie>i);
        i=0;
        for (String key : this.attacks.keySet()){
            if (i==saisie){
                value = this.attacks.get(key);
                break;
            }
            i++;
        }
        return value;
    }

    public void setAttack(String attack, int damages) {
        if (this.attacks.size() == 4){
            Scanner sc = new Scanner(System.in);
            System.out.println("Whick attack do you want to replace by the new one?");
            int i = 0;
            for (String key : this.attacks.keySet()){
                System.out.println(i + ": " + key + " — Damages: " + this.attacks.get(key));
                i+=1;
            }
            int saisie;
            do{
                saisie = sc.nextInt();
            }while(saisie>i);
            i=0;
            for (String key : this.attacks.keySet()){
                if (i==saisie){
                    this.attacks.remove(key);
                    this.attacks.put(attack, damages);
                    break;
                }
            }
        }
        else {
            this.attacks.put(attack, damages);
        }
    }

    public HashMap<String, Integer> getAttacks() {
        return this.attacks;
    }
}
