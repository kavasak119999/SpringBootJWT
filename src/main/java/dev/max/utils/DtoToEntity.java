package dev.max.utils;

import dev.max.dto.Product;
import dev.max.dto.User;
import dev.max.entity.ProductEntity;
import dev.max.entity.RoleEntity;
import dev.max.entity.UserEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

public class DtoToEntity {

    public static UserEntity userDtoToEntity(User user, RoleEntity roleEntity) {
        String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        List<RoleEntity> userRoles = new ArrayList<>();
        userRoles.add(roleEntity);

        return UserEntity.builder()
                .username(user.getUsername())
                .password(hash)
                .roles(userRoles)
                .build();
    }

    public static ProductEntity productDtoToEntity(Product product){
        return ProductEntity.builder()
                .id(product.getId())
                .entryDate(product.getEntryDate())
                .itemCode(product.getItemCode())
                .itemName(product.getItemName())
                .itemQuantity(product.getItemQuantity())
                .status(product.getStatus())
                .build();
    }
}