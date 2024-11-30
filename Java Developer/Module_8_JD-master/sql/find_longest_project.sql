SELECT project.ID,
       EXTRACT(MONTH FROM project.START_DATE) AS START_MONTH,
       EXTRACT(MONTH FROM project.FINISH_DATE) AS FINISH_MONTH
FROM project
ORDER BY START_MONTH, FINISH_MONTH DESC;