package com.codestates.coffee.service;

import com.codestates.coffee.entity.Coffee;
import org.springframework.stereotype.Service;

import java.util.List;
//import com.codestates.member.entity.Member;

@Service
public class CoffeeService {
    //postCoffee
    public Coffee createCoffee(Coffee coffee){
        return coffee;
    }

    //patchCoffee
    public Coffee updateCoffee(Coffee coffee){
        return coffee;
    }

    //getCoffee
    public Coffee findCoffee(long coffeeId){
        Coffee coffee = new Coffee(coffeeId, "아메리카노", "Americano", 4500);
        return coffee;
    }

    //getCoffees
    public List<Coffee> findCoffees(){
        List<Coffee> coffee = List.of(
                new Coffee(1, "아메리카노","americano",4500),
                new Coffee(2, "라떼","lattee",5000)
                );

        return coffee;
    }

    //deleteCoffee
    public void deleteCoffee(long coffeeId){

    }
}
