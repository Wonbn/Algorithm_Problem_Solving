# select MCDP_CD 진료과코드, count(*) 5월예약건수
# from APPOINTMENT
# where to_char(APNT_YMD, 'yyyymm') is '202205'
# group by MCDP_CD
# order by count(MCDP_CD), MCDP_CD;

select MCDP_CD 진료과코드 , COUNT(APNT_YMD) 5월예약건수
from APPOINTMENT 
where APNT_YMD LIKE '2022-05-%'
group by MCDP_CD
order by count(APNT_YMD), MCDP_CD