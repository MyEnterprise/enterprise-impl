package com.voyager.enterprise.impl.domain.entities.lending;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

import javax.persistence.*;

import com.voyager.enterprise.impl.domain.entities.merchandise.CoinEntity;
import com.voyager.enterprise.util.Code;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class InterestEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column
    private Code<String> code;
	@Column
    private Map<String,String> attributes;
	@Column
    private String desc;
	@OneToOne
    private CoinEntity coin;
	@OneToOne
    private BigDecimal amount;

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Code<String> getCode() {
		return code;
	}
	public void setCode(Code<String> code) {
		this.code = code;
	}
	public Map<String, String> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public CoinEntity getCoin() {
		return coin;
	}
	public void setCoin(CoinEntity coin) {
		this.coin = coin;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
