package com.shokanmyrzaxmet.springMVC.controllers;
import com.shokanmyrzaxmet.springMVC.dao.HeroesDAO;
import com.shokanmyrzaxmet.springMVC.entity.Heroes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class KonohaController {
    private  final HeroesDAO heroesDAO;

    public KonohaController(HeroesDAO heroesDAO) {
        this.heroesDAO = heroesDAO;
    }

    @GetMapping()
    public String getHeroes( Model model){
        model.addAttribute("heroes",heroesDAO.getHeroes() );
        return "konoha/heroes.html";
}

@GetMapping("/konoha/{id}")
    public String showHero(@PathVariable("id")int id,Model model){
        model.addAttribute("oneHero",heroesDAO.show(id));
        return "konoha/show.html";
}
@GetMapping("/konoha/newHero")
    public String newHero(Model model){
        model.addAttribute("hero",new Heroes());
        return "konoha/newHero.html";
}
@PostMapping()
    public String addHero(@ModelAttribute("hero") Heroes heroes){
         heroesDAO.addHeroes(heroes);
         return "redirect:/konoha";
}
@GetMapping("/konoha/{id}/update")
    public String update(@PathVariable("id") int id,Model model){
        model.addAttribute("hero",heroesDAO.show(id));
        return "konoha/update.html";
}
@PatchMapping("/konoha/{id}")
    public String editHero(@ModelAttribute("hero") Heroes heroes,@PathVariable("id") int id){
        heroesDAO.updateHero(id,heroes);
        return "redirect:/konoha";
}
@DeleteMapping("/konoha/{id}")
    public String delete(@PathVariable("id") int id){
        heroesDAO.delete(id);
        return "redirect:/konoha";
}



}
