package pojo;

import java.util.List;

/** 
* @author chj E-mail: 865477704@qq.com
* @version 创建时间：2017年5月16日 下午8:06:20 
* 类说明   分页模型
 * @param <T>
*/
public class PageModel<T> {
	// Fields

		private int pageNo;    // Current page number
		private int pageSize; // Size of each page
		private int recordCount; // Total number of records
		private int pageCount;   // Total number of page
		private List<T> datas;   // List of data in page
		// Constructor

		public PageModel(){}
		
		public PageModel(int pageNo, int pageSize){
			this.pageNo=pageNo;
			this.pageSize=pageSize;
		}

		// Setters and getters

		public int getPageNo() {
			return pageNo;
		}

		public void setPageNo(int pageNo) {
			this.pageNo = pageNo;
		}

		public int getPageSize() {
			return pageSize;
		}

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}

		public int getRecordCount() {
			return recordCount;
		}

		public void setRecordCount(int recordCount) {
			this.recordCount = recordCount;
		}

		public int getPageCount() {
			if(this.getRecordCount()<=0){
				return 0;
			}else{
				pageCount = (recordCount + pageSize - 1)/pageSize;
			}
			return pageCount;
		}

		public void setPageCount(int pageCount) {
			this.pageCount = pageCount;
		}

		public List<T> getDatas() {
			return datas;
		}

		public void setDatas(List<T> datas) {
			this.datas = datas;
		}
}
 