select distinct a.USER_ID, a.PRODUCT_ID
from ONLINE_SALE a join ONLINE_SALE b
where a.USER_ID = b.USER_ID
and a.PRODUCT_ID = b.PRODUCT_ID
and a.ONLINE_SALE_ID != b.ONLINE_SALE_ID
order by a.USER_ID, a.PRODUCT_ID desc;
