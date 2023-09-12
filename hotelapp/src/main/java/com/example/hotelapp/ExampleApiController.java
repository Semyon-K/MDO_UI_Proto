package com.example.hotelapp;


// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/example")
class ExampleApiController {

    // @Autowired
    // ExampleService exampleService;
    // @Autowired
    // ExampleRepository exampleRepository;

    // @GetMapping
    // public ResponseEntity<List<Example>> getAll() {
    //     try {
            
    //        List<Example> items = exampleService.GetExamples();

    //         if (items.isEmpty())
    //             return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    //         return new ResponseEntity<>(items, HttpStatus.OK);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    // @GetMapping("{id}")
    // public ResponseEntity<Example> getById(@PathVariable("id") Long id) {
    //     Example example = exampleService.GetExample(id);

    //     if (example instanceof Example) {
    //         return new ResponseEntity<>(example, HttpStatus.OK);
    //     } else {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    // }

    // @PostMapping
    // public ResponseEntity<Example> create(@RequestBody Example example) {
    //     try {
    //         Example savedItem = exampleService.CreateExample(example);
    //         return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
    //     }
    // }

    // @PutMapping("{id}")
    // public ResponseEntity<Example> update(@PathVariable("id") Long id, @RequestBody Example example) {
    //     Optional<Example> exisitngExample = exampleRepository.findById(id);
    //     if (exisitngExample.isPresent()) {
    //         Example existingItem = exampleService.UpdateExample(id, example);

    //         return new ResponseEntity<>(existingItem, HttpStatus.OK);
    //     } else {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    // }

}