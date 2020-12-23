package com.cosmetics.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetics.models.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

	public List<Invoice> findByclient_Id(long client);
	public Invoice findByorder_Id(long order);
}
