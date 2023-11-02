select o.ANIMAL_ID, o.NAME
from ANIMAL_INS i right join ANIMAL_OUTS o
on i.ANIMAL_ID = o.ANIMAL_ID
where i.DATETIME is null
order by ANIMAL_ID, NAME;