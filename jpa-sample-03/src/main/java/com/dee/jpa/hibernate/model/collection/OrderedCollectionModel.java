package com.dee.jpa.hibernate.model.collection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

/**
 * @author dien.nguyen
 **/

@Entity
@Table(name = "cln_order_collection")
public class OrderedCollectionModel implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "cln_order_article_lazy", joinColumns  = {@JoinColumn(name = "ordered_cln_id")})
    @Column(name = "content")
    private List<String> articlesLazyLoading = new ArrayList<String>();
    
    @ElementCollection
    @CollectionTable(name = "cln_order_favourites_not_ordered", joinColumns  = {@JoinColumn(name = "ordered_cln_id")})
    @Column(name = "favourite_thing")
    private List<String> favouritesNotOrdered = new ArrayList<String>();
    
    @ElementCollection
    @CollectionTable(name = "cln_order_favourites", joinColumns  = {@JoinColumn(name = "ordered_cln_id")})
    @Column(name = "favourite_thing")
    @OrderBy(value = "favourite_thing")
    private List<String> favourites = new ArrayList<String>();
    
    @ElementCollection
    @CollectionTable(name = "cln_order_favourites_persistent", joinColumns  = {@JoinColumn(name = "ordered_cln_id")})
    @Column(name = "favourite_thing")
    @OrderColumn(name = "favourite_order")
    private List<String> favouritesPersistentOrder = new ArrayList<String>();
    
    @ElementCollection(targetClass = OrderedCollectionAddressModel.class)
    @CollectionTable(name = "cln_order_address_1", joinColumns  = {@JoinColumn(name = "ordered_cln_id")})
    @AttributeOverrides(value = {
            @AttributeOverride(name = "city", column = @Column(name = "city_name")), 
            @AttributeOverride(name = "address", column = @Column(name = "address_info"))})
    @OrderBy(value = "address_info")
    private List<OrderedCollectionAddressModel> addresses = new ArrayList<OrderedCollectionAddressModel>();
    
    @ElementCollection
    @CollectionTable(name = "cln_order_phone_1", joinColumns  = {@JoinColumn(name = "ordered_cln_id")})
    @OrderBy(value = "phone_number")
    @Column(name = "phone_number")
    private Set<String> phones = new HashSet<String>();

    public List<String> getFavourites() {
        return favourites;
    }

    public void setFavourites(List<String> favourites) {
        this.favourites = favourites;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getFavouritesNotOrdered() {
        return favouritesNotOrdered;
    }

    public void setFavouritesNotOrdered(List<String> favouritesNotOrdered) {
        this.favouritesNotOrdered = favouritesNotOrdered;
    }

    public List<OrderedCollectionAddressModel> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<OrderedCollectionAddressModel> addresses) {
        this.addresses = addresses;
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    public List<String> getArticlesLazyLoading() {
        return articlesLazyLoading;
    }

    public void setArticlesLazyLoading(List<String> articlesLazyLoading) {
        this.articlesLazyLoading = articlesLazyLoading;
    }

    public List<String> getFavouritesPersistentOrder() {
        return favouritesPersistentOrder;
    }

    public void setFavouritesPersistentOrder(List<String> favouritesPersistentOrder) {
        this.favouritesPersistentOrder = favouritesPersistentOrder;
    }

}
