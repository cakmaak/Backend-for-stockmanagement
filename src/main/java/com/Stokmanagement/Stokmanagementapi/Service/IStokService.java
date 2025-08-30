package com.Stokmanagement.Stokmanagementapi.Service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;

import com.Stokmanagement.Stokmanagementapi.Entity.Stok;


public interface IStokService  {
	
	public Stok saveStokHistory(Stok stockhistory,Long productid);
	public List<Stok> getallstokhistory();
	public ResponseEntity<?> deleteStok(Long id, Authentication authentication);

}
