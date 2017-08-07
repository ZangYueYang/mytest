package cn.itcast.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.exception.ItcastException;
import cn.itcast.pojo.Items;
import cn.itcast.pojo.QueryVo;
import cn.itcast.service.ItemsService;

@Controller
@RequestMapping("/items")
public class ItemsController {
	@Autowired
	private ItemsService itemsService;

//	@RequestMapping(value="/list", method=RequestMethod.GET)
	@RequestMapping(value="/list")
	public ModelAndView getItemsList() throws Exception {
//		int i = 0/0;
		
//		if (true) {
//			// 业务违规
//			ItcastException e = new ItcastException();
//			e.setMessage("您已经购买过一件，请不要太贪心！！！");
//			throw e;
//		}
		List<Items> itemsList = itemsService.getItemsList();
		
		ModelAndView modelAndView = new ModelAndView();
		
		// request.setAttribute(key, value)
		// 底层仍然是把属性名和属性值放到request对象中
		// jsp页面永远是从request对象中取得数据的
		modelAndView.addObject("itemsList", itemsList);
		
		modelAndView.setViewName("items/itemList");
		
		return modelAndView;
	}
	
	/**
	 * 根据商品id取得商品详细信息
	 * 
	 * @return 返回对应商品的详细信息
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public String getItemsInfoById(HttpServletRequest request, Model model) throws Exception {
		Integer id = Integer.valueOf(request.getParameter("id"));
		// 根据id查询商品信息
		Items items = itemsService.getItemsInfoById(id);
		model.addAttribute("item", items);
		return "items/editItem";
	}
	
//	@RequestMapping("/updateitem")
//	public String updateItemsInfo(Integer id, String name, 
//			Float price, String detail) throws Exception {
//		Items items = new Items();
//		items.setId(id);
//		items.setName(name);
//		items.setPrice(price);
//		items.setDetail(detail);
//		itemsService.updateItems(items);
//		return "items/success";
//	}
	
//	@RequestMapping("/updateitem")
//	public String updateItemsInfo(Items items) throws Exception {
//		itemsService.updateItems(items);
//		return "items/success";
//	}
	
//	@RequestMapping("/updateitem")
//	public String updateItemsInfo(Items items, Model model, HttpServletRequest request) throws Exception {
//		itemsService.updateItems(items);
////		model.addAttribute("id", items.getId());
//		request.setAttribute("id", items.getId());
//		return "forward:toEdit.action";
//	}
	
	@RequestMapping("/updateitem")
	public String updateItemsInfo(MultipartFile pictureFile, Items items, Model model, HttpServletRequest request) throws Exception {
		// 1. 获取图片原始的文件名
		String orgFileName = pictureFile.getOriginalFilename();
		// 2. 随机生成字符串 + 原文件的扩展名组成新的文件名称
		String newFileName = UUID.randomUUID().toString() + orgFileName.substring(orgFileName.lastIndexOf("."));
		// 3. 将图片保存到磁盘
		pictureFile.transferTo(new File("F:\\2333\\SpringMVC第1天\\image" + newFileName));
		// 4. 将新的图片名称保存到数据库
		items.setPic(newFileName);
		
		itemsService.updateItems(items);
		model.addAttribute("id", items.getId());
//		request.setAttribute("id", items.getId());
		return "redirect:/items/toEdit.action";
	}
	
	@RequestMapping("/queryitem")
	public String queryItemsInfo(QueryVo vo) throws Exception {
		
		return "items/success";
	}

	@RequestMapping("/listForDel")
	public ModelAndView listForDel() throws Exception {
		List<Items> itemsList = itemsService.getItemsList();
		
		ModelAndView modelAndView = new ModelAndView();
		
		// request.setAttribute(key, value)
		// 底层仍然是把属性名和属性值放到request对象中
		// jsp页面永远是从request对象中取得数据的
		modelAndView.addObject("itemsList", itemsList);
		
		modelAndView.setViewName("items/itemListDelBatch");
		
		return modelAndView;
	}
	
//	@RequestMapping("/delBatch")
//	public String delBatch(String[] ids) throws Exception {
//		// 批量删除，遍历数据，每次删除一条
//		
//		return "items/success";
//	}
	
	@RequestMapping("/delBatch")
	public String delBatch(QueryVo vo) throws Exception {
		// 批量删除，遍历数据，每次删除一条
		
		return "items/success";
	}

	@RequestMapping("/listForUpd")
	public ModelAndView listForUpd() throws Exception {
		List<Items> itemsList = itemsService.getItemsList();
		
		ModelAndView modelAndView = new ModelAndView();
		
		// request.setAttribute(key, value)
		// 底层仍然是把属性名和属性值放到request对象中
		// jsp页面永远是从request对象中取得数据的
		modelAndView.addObject("itemsList", itemsList);
		
		modelAndView.setViewName("items/itemListUpdBatch");
		
		return modelAndView;
	}
	
	@RequestMapping("/updateBatch")
	public String updBatch(QueryVo vo) throws Exception {
		// 批量删除，遍历数据，每次删除一条
		
		return "items/success";
	}
	
	@RequestMapping("/sendJson")
	@ResponseBody
	public Items sendJson(@RequestBody Items items) throws Exception {
		items.setDetail("text json");
		
		return items;
	}
	
	
	
	
	
	
	
	
	
	
}
