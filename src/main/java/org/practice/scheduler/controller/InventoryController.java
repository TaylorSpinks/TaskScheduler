package org.practice.scheduler.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @GetMapping
    public String GetInventory(){
        // todo: this won't work well for state management. need some service to manage the flow of requests (fix in kotlin probably)
        return "Not implemented";
    }
}
