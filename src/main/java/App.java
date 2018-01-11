import models.Word;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

//        shows home page
        get("/", (request, response)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        },  new HandlebarsTemplateEngine());

//        show new word form
        get("/words/new", (request, response)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "form.hbs");
        },  new HandlebarsTemplateEngine());

//        process a new word form
        post("/words/new", (request, response)->{
            Map<String, Object> model = new HashMap<>();
            String entry = request.queryParams("entry");
            String type = request.queryParams("type");
            String definition = request.queryParams("definition");
            String synonym = request.queryParams("synonym");
            Word newWord = new Word(entry, type, definition, synonym);
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

//        show processed words
        get("/words/all", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Word> words = Word.getAll();
            model.put("words", words);
            return new ModelAndView(model, "all-words.hbs");
        }, new HandlebarsTemplateEngine());

//        show an individual post
        get("/words/:id",(req, res) -> {
            Map<String,Object> model = new HashMap<>();
            int idOfWordToFind = Integer.parseInt(req.params("id"));
            Word foundWord = Word.findById(idOfWordToFind);
            model.put("word", foundWord);
            return new ModelAndView(model, "word-detail.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show a form to update a post
        get("/words/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfWordToEdit = Integer.parseInt(req.params("id"));
            Word editWord = Word.findById(idOfWordToEdit);
            model.put("editWord", editWord);
            return new ModelAndView(model, "edit.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process a form to update a post.

        post("/words/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String newDefinition = req.queryParams("definition");
            int idOfWordToEdit = Integer.parseInt(req.params("id"));
            Word editWord = Word.findById(idOfWordToEdit);
            editWord.update(newDefinition); //don’t forget me
            return new ModelAndView(model, "word-detail.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
