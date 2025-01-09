package com.codestates.coffee.mapper;

import com.codestates.coffee.dto.CoffeePatchDto;
import com.codestates.coffee.dto.CoffeePostDto;
import com.codestates.coffee.dto.CoffeeResponseDto;
import com.codestates.coffee.entity.Coffee;
import org.springframework.stereotype.Component;

@Component
public class CoffeeMapper {
    public Coffee coffeePostDtoToCoffee(CoffeePostDto coffeePostDto){
        Coffee coffee = new Coffee();
        coffee.setKorName(coffeePostDto.getKorName());
        coffee.setEngName(coffeePostDto.getEngName());
        coffee.setPrice(coffeePostDto.getPrice());

        return coffee;
    }
    public Coffee coffeePatchDtoToCoffee(CoffeePatchDto coffeePatchDto){
        Coffee coffee = new Coffee();
        coffee.setCoffeeId(coffeePatchDto.getCoffeeId());
        coffee.setKorName(coffeePatchDto.getKorName());
        coffee.setEngName(coffeePatchDto.getEngName());
        coffee.setPrice(coffeePatchDto.getPrice());

        return coffee;
    }

    public CoffeeResponseDto coffeeToCoffeeResponseDto(Coffee coffee){
        CoffeeResponseDto coffeeDto = new CoffeeResponseDto(
                coffee.getCoffeeId(),
                coffee.getKorName(),
                coffee.getEngName(),
                coffee.getPrice()
        );

        return coffeeDto;
    }
}
