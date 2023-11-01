select u.USER_ID, u.NICKNAME, sum(b.PRICE) TOTAL_SALES
from USED_GOODS_BOARD b join USED_GOODS_USER u
on b.WRITER_ID = u.USER_ID
where status = 'DONE'
group by b.WRITER_ID
having TOTAL_SALES >= 700000
order by TOTAL_SALES;