with pur as (
  select table_name, constraint_type, constraint_name, r_constraint_name,
    max(decode(constraint_type,'R',1,0)) over(partition by table_name) is_r
  from user_constraints 
  where constraint_type in ('P', 'U', 'R') and table_name like 'hrc%'
)
, son_dad as (
  select distinct s.table_name son, d.table_name dad, d.constraint_type
  from (select * from pur where constraint_type = 'R' or is_r = 0) s
  left join pur d
    on s.r_constraint_name = d.constraint_name
    and s.table_name != d.table_name
)
select level lvl, son, dad, constraint_type
from son_dad
start with dad is null
connect by dad = prior son
order siblings by dad, son;
