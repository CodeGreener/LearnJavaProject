# Write your MySQL query statement below
select d.Name Department, e.Name Employee,e.Salary
from Department d join Employee e on d.Id = e.DepartmentId
join (select e.DepartmentId, max(e.Salary) Salary from Employee e
group by e.DepartmentId) ss
on e.Salary = ss.Salary and d.Id = ss.DepartmentId

