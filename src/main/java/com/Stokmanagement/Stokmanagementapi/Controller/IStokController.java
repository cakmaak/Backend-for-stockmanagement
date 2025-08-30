package com.Stokmanagement.Stokmanagementapi.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import com.Stokmanagement.Stokmanagementapi.Entity.Stok;

public interface IStokController {
	
	public Stok saveStokHistory(Stok stokhistory,Long productid);
	public List<Stok> getallstokhistory();
	public ResponseEntity<?> deleteStok(Long id, Authentication authentication);

}
