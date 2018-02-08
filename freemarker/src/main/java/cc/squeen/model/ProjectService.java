package cc.squeen.model;

import cc.squeen.model.Project;
import cc.squeen.model.ProjectQuery;

import java.util.List;

/**
 *
 * @author sang
 *
 */
public interface ProjectService {
	//查询集合
	public List<Project> getProjectList(ProjectQuery entityQuery);
	//添加
	public void addProject(Project entity);
	//删除
	public void deleteProjectByKey(Integer id);
	//删除 批量
	public void deleteProjectByKeys(Integer[] ids); //List<Integer>  ids
	//修改
	public void updateProjectByKey(Project entity);
	//根据id 查询
	public Project getProjectByKey(Integer id);
}
