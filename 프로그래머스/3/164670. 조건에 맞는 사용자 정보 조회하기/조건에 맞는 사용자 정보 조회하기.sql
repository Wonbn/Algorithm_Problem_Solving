select u.USER_ID, u.NICKNAME, 
concat(CITY, ' ', STREET_ADDRESS1, ' ', STREET_ADDRESS2) 전체주소, 
concat(left(TLNO, 3), '-', mid(TLNO, 4, 4), '-', right(TLNO, 4)) 전화번호
from USED_GOODS_BOARD b join USED_GOODS_USER u
on b.WRITER_ID = u.USER_ID
group by b.WRITER_ID
having count(b.BOARD_ID) >= 3
order by u.USER_ID desc;

