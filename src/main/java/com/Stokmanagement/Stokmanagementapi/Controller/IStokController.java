package com.Stokmanagement.Stokmanagementapi.Controller;

import java.util.List;

import com.Stokmanagement.Stokmanagementapi.Entity.Stok;

public interface IStokController {
	
	public Stok saveStokHistory(Stok stokhistory,Long productid);
	public List<Stok> getallstokhistory();

}
