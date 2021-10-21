package com.amr.project.model.dto;

import com.amr.project.model.entity.Country;
import com.amr.project.model.entity.Image;
import lombok.*;
import org.mapstruct.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemDto {
    private Long id;
    private String name;
    private String[] categoriesName;
    private Integer count;
    private BigDecimal price;
    private List<ImageDto> images;
    private Double rating;
    private String description;

    private String shopName;
    private String shopPhone;
    private ImageDto shopLogo;
    private CountryDto shopLocation;

    private boolean isModerateAccept;
    private boolean isModerated;
    private boolean isPretendentToBeDeleted;
    private String moderatedRejectReason;
    private List<CategoryDto> categories;
    private List<ReviewDto> reviews;
    private Long shopId;

    public String printRating() {
        if (!reviews.isEmpty()) {
            return String.format("%.1f", reviews.stream().mapToDouble(ReviewDto::getRating).sum() / reviews.size());
        }
        return null;
    }

    public Long getRating() {
        if (!reviews.isEmpty()) {
            return Math.round(reviews.stream().mapToDouble(ReviewDto::getRating).sum() / reviews.size());
        }
        return null;
    }
}
