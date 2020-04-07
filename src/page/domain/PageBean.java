package page.domain;

import java.util.List;

/**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/4/7 15:03
 */
public class PageBean<T> {
    private int currPage;//当前页码 page code
    // private int totalPage;//总页数
    private int totalRecord;//总记录数
    private int pageSize;//每页记录数
    private List<T> beanList;//当前页的记录

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getTotalPage() {

        int totalPage = totalRecord / pageSize;

        return totalPage % pageSize == 0 ? totalPage : totalPage + 1;
    }

//    public void setTotalPage(int totalPage) {
//        this.totalPage = totalPage;
//    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }
}
