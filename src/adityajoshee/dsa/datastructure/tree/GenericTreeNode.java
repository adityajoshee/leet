package adityajoshee.dsa.datastructure.tree;

import java.util.Collection;

/**
 * Created by aditya on 7/25/16.
 */
public class GenericTreeNode<T> {
    private T data ;
    private String meta ;
    private Integer id;
    private Collection<GenericTreeNode<T>> children;

    public T getData() {
        return data;
    }

    public Collection<GenericTreeNode<T>> getChildren() {
        return children;
    }

    public void setChildren(Collection<GenericTreeNode<T>> children) {
        this.children = children;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
