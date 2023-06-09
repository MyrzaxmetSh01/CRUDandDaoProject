package com.shokanmyrzaxmet.springMVC.dao;
import com.shokanmyrzaxmet.springMVC.entity.Heroes;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
@Component
public class HeroesDAO{
    private ArrayList<Heroes> heroes;
    private static int id;
    {
        heroes=new ArrayList<Heroes>();
        heroes.add(new Heroes(++id,"Naruto","Hokage"));
        heroes.add( new Heroes(++id,"Kakashi","Hokage"));
        heroes.add(new Heroes(++id,"Sasuke","Dzhonin"));
        heroes.add(  new Heroes(++id ,"Sakura","Dzhonin"));
    }

    public ArrayList<Heroes> getHeroes(){
        return heroes;
    }

     public void addHeroes(Heroes hero){
        hero.setId(++id);
        heroes.add(hero);
     }

     public Heroes show(int id){
        return heroes.stream()
                .filter(h -> h.getId() == id).findAny().orElse(null);
     }

     public void updateHero(int id,Heroes heroes){
        Heroes updatedHero = show(id);

        updatedHero.setName(heroes.getName());
        updatedHero.setRang(heroes.getRang());
     }
     public void delete(int id){
        heroes.removeIf(h->h.getId()==id);
     }
}
