package com.Stokmanagement.Stokmanagementapi.Service;

import com.Stokmanagement.Stokmanagementapi.Entity.Stok;


public interface IStokService  {
	
	public Stok saveStokHistory(Stok stockhistory,Long productid);

}
