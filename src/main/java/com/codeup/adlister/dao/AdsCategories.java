package com.codeup.adlister.dao;

import java.util.List;

public interface AdsCategories {
    List<Long> getCategoriesByAdId(long adId);
    void joiningAdsToCategories (long adId, long catId);

}
