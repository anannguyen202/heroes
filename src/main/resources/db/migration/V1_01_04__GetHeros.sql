DROP FUNCTION IF EXISTS get_heros();

CREATE OR REPLACE FUNCTION get_heros()
  RETURNS TABLE("id" INT4, "name" varchar) AS $BODY$
BEGIN
	RETURN QUERY
	(SELECT h.id, h.name
	FROM public.hero h);
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000