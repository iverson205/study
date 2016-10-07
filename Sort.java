class Sort 
{
	static int[] arr = { 5, 2, 4, 2, 6, 4, 8, 7, 9, 2, 4, 6, 0, 10 };

	public static void main(String[] args)
	{
		// bubble_Sort(arr.length);
		// insert_Sort(arr.length);
		// select_Sort(arr.length);
		quick_Sort(0, arr.length);

	}

	private static void quick_Sort(int i, int j)
	{
		int k = partition(i, j);
		if ((k - i) > 1)
			quick_Sort(i, k);
		if ((j - k) > 1)
			quick_Sort(k + 1, j);
		show();

	}

	private static int partition(int i, int j)
	{
		int key = arr[i];
		int temp;
		while (i < j)
		{
			while (j > 0 && arr[--j] > key);//从后向前扫描到比key小的元素
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			while (i < j && arr[++i] < key);// 从前向后扫描到比key大的元素
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		show();
		return i;

	}

	private static void select_Sort(int n)
	{
		int max, flag;
		for (int i = 0; i < n; i++)
		{
			max = arr[0];
			flag = 0;
			for (int j = 0; j < n - i; j++)
			{
				if (arr[j] > max)
				{
					max = arr[j];
					flag = j;//记录最大值的下标
				}
			}
			//更新位置
			arr[flag] = arr[n - 1 - i];
			arr[n - 1 - i] = max;
			show();
		}

	}

	private static void insert_Sort(int n)
	{
		for (int i = 1; i < n; i++)// 待插入的元素
		{
			int a = arr[i];
			for (int j = i - 1; j >= 0; j--)// j表示已排序的元素
			{
				if (a >= arr[j])
					break;
				if (a < arr[j])
				{
					arr[i] = arr[j];
					arr[j] = a;
					i = j;
				}
			}
			show();
		}

	}

	public static void show()
	{
		for (int b : arr)
		{
			System.out.print(b + " ");
		}
		System.out.println();
	}

	private static void bubble_Sort(int n)
	{
		int temp = 0;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n - i - 1; j++)
			{
				if (arr[j] > arr[j + 1])
				{
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			show();
		}
	}

}

}
