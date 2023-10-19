package com.voyager.enterprise.impl.financial.entities;

import com.voyager.enterprise.financial.entity.enums.WalletEnum;

public class WalletEntity {
	public WalletEnum type;
    public boolean hasEncrypted;
    public String algorithmEncrypted;
    public String region;
    public String local;
}
