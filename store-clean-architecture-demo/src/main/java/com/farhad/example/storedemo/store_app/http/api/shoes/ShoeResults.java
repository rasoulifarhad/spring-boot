package com.farhad.example.storedemo.store_app.http.api.shoes;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShoeResults {
	private List<ShoeData> shoes;
}
