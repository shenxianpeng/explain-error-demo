import pytest

from inventory.stock import OutOfStock, Stock


def test_reserve_takes_units_off_the_shelf():
    stock = Stock({"SKU-1042": 12})
    assert stock.reserve("SKU-1042", 5) == 7


def test_reserve_refuses_more_than_is_available():
    stock = Stock({"SKU-1042": 2})
    with pytest.raises(OutOfStock):
        stock.reserve("SKU-1042", 3)


def test_unknown_sku_has_no_stock():
    assert Stock().available("SKU-0000") == 0
