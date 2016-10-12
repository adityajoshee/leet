package datastructure.tree;

import java.util.Collection;

/**
 * Created by aditya on 7/25/16.
 */
public class TreeNode<T> {
    private T data ;
    private String meta ;
    private Integer id;
    private Collection<TreeNode<T>> children;

    public T getData() {
        return data;
    }

    public Collection<TreeNode<T>> getChildren() {
        return children;
    }

    public void setChildren(Collection<TreeNode<T>> children) {
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
