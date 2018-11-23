DROP FUNCTION IF EXISTS get_total_hero();

CREATE OR REPLACE FUNCTION get_total_hero()
  RETURNS TABLE("total" INT4) AS $BODY$
BEGIN
	RETURN QUERY
	(SELECT cast(count(*) as integer)
	FROM hero h);
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000