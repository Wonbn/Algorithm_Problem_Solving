select DR_NAME, DR_ID, MCDP_CD, Date_format(HIRE_YMD, '%Y-%m-%d') HIRE_YMD
from DOCTOR
where MCDP_CD = 'CS' or MCDP_CD = 'GS'
order by HIRE_YMD desc, DR_NAME;