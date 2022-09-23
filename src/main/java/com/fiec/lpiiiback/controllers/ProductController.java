package com.fiec.lpiiiback.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiec.lpiiiback.models.dto.ProductRequestDto;
import com.fiec.lpiiiback.models.dto.ProductResponseDto;
import com.fiec.lpiiiback.models.entities.Product;
import com.fiec.lpiiiback.models.enums.UserRoles;
import com.fiec.lpiiiback.services.ProductService;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<ProductResponseDto> getAllProducts(){
        return productService.findAllProducts().stream().map(ProductResponseDto::convert).collect(Collectors.toList());
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ProductResponseDto insertProduct(@RequestParam("productInfo") String productRequest,
                                            @RequestParam("image") MultipartFile multipartFile
    ) throws IOException {

        ProductRequestDto productRequestDto = new ObjectMapper().readValue(productRequest, ProductRequestDto.class);

        String profileImage = "prd" + UUID.randomUUID() + "_" + Long.toHexString(new Date().getTime());

        Path filename = Paths.get("uploads").resolve(profileImage);
        Path thumbFilename = Paths.get("uploads").resolve("thumb_" + profileImage);
        Thumbnails.of(multipartFile.getInputStream())
                .size(500, 500)
                .outputFormat("jpg")
                .toFile(new File(filename.toString()));
        Thumbnails.of(multipartFile.getInputStream())
                .size(100, 100)
                .outputFormat("jpg")
                .toFile(new File(thumbFilename.toString()));
        Product insertedProduct = productService.insertNewProduct(productRequestDto, profileImage);
        return ProductResponseDto.convert(insertedProduct);

    }
}
