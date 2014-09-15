package com.vending.items;

public interface Item<T extends Item<?>> {

	public abstract String getName();

	public abstract Double getPrice();

}