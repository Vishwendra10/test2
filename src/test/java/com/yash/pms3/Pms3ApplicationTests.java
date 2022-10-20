package com.yash.pms3;

import static org.assertj.core.api.Assertions.assertThat;



import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.yash.pms3.controller.MyController;
import com.yash.pms3.dao.ProductDao;
import com.yash.pms3.model.Product;
import com.yash.pms3.serviceimpl.ProductServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
 


@SpringBootTest  // To run as a whole spring container as bootstrap

//@RunWith(MockitoJUnitRunner.class) or Mockito.initMocks(this)   JUnit4
//@ExtendWith(MockitoExtension.class)				JUnit5
public class Pms3ApplicationTests {
	
	@Mock
	ProductDao productdao;
	
//	@InjectMocks
//	ProductServiceImpl productserviceimpl;
	@Mock
	ProductServiceImpl productserviceimpl;
	
	@Autowired
	private MyController controller;
	
//	@Before
//	void setup(){
//	MockitoAnnotations.initMocks(this);
//	}
	
	@Test
	public void test1() {
		assertThat(controller).isNotNull();
	}

	@Test
	public void testProductgetDetailsReturnsProductList(){
		
		List<Product> productlist= new ArrayList<>();
		productlist.add(new Product(1L,"pen", 30));
		productlist.add(new Product(2L,"pencil", 20));
		productlist.add(new Product(3L,"notebook", 60));
		
		Mockito.when(productdao.findAll()).thenReturn(productlist);
//		assertThat(productserviceimpl.getDetails()).isEqualTo(productlist);
		assertEquals(productlist ,productserviceimpl.getDetails());
		
	}
	
	@Test
	public void testProductSaveDetailsReturnsProduct()
	{
		Product product=new Product(1L,"pen", 30);
		
		Mockito.when(productdao.save(product)).thenReturn(product);
		assertThat(productserviceimpl.save(product)).isEqualTo(product);
	}
	
//	@Test
//	public void testProductDeleteByIdIsExecutedOrNot() throws Exception
//	{
//			Product product=new Product(1L,"pen", 30);
//			long pid=product.getPid();
//			try
//			{
//				Mockito.verify(controller.delDetails(pid));
//			}
//			catch (ResourceNotFoundException e){
//				Mockito.doThrow(new ResourceNotFoundException("Product", "Id", pid));
//			}
//	}
//	
//	@Test
//	public void testProductGetDetailsByIdReturnsProduct() throws Exception
//	{
//		Product product=new Product(1L,"pen", 30);
//		long pid=1L;
//		try
//		{
////			Mockito.when(productdao.findById(pid)).thenReturn(product);
////			assertThat(productserviceimpl.getDetailsById(pid)).isEqualTo(product);
//			Mockito.verify(controller.getDetailsById(pid));
//		}
//		catch(ResourceNotFoundException e)
//		{
//			Mockito.doThrow(new ResourceNotFoundException("Product","Id",pid));
//		}
//
//		
//	}
}
