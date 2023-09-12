package com.farhad.example.storedemo.store_app.http.api.shoes;

import java.util.List;

import lombok.Data;

@Data
public class ShoeResults {
	private List<ShoeData> shoes;
}
