package com.Stokmanagement.Stokmanagementapi.Service;

import java.util.List;

import com.Stokmanagement.Stokmanagementapi.Entity.Stok;


public interface IStokService  {
	
	public Stok saveStokHistory(Stok stockhistory,Long productid);
	public List<Stok> getallstokhistory();

}
