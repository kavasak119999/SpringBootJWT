package dev.max.utils;

import dev.max.dto.Product;
import dev.max.dto.Role;
import dev.max.dto.User;
import dev.max.entity.ProductEntity;
import dev.max.entity.RoleEntity;
import dev.max.entity.UserEntity;

import java.util.stream.Collectors;

public class EntityToDto {

    public static User userEntityToDto(UserEntity userEntity){
        return User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .roles(userEntity.getRoles().stream().map(EntityToDto::roleEntityToDto).collect(Collectors.toSet()))
                .build();
    }

    public static Role roleEntityToDto(RoleEntity roleEntity){
        return Role.builder()
                .id(roleEntity.getId())
                .name(roleEntity.getName())
                .build();
    }

    public static Product productEntityToDto(ProductEntity productEntity){
        return Product.builder()
                .id(productEntity.getId())
                .entryDate(productEntity.getEntryDate())
                .itemCode(productEntity.getItemCode())
                .itemName(productEntity.getItemName())
                .itemQuantity(productEntity.getItemQuantity())
                .status(productEntity.getStatus())
                .build();
    }
}
