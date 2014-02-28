package com.kidsconnect.domain.model;


import java.util.Iterator;

import com.google.common.collect.ImmutableList;


public class ResultSet<Entity extends DomainClass>
{
    private final ImmutableList<Entity> results;
    private final Pagination pagination;
    private String resultType = null;

    public ResultSet(ImmutableList<Entity> results, Pagination pagination)
    {
	this.results = results;
        this.pagination = pagination;
    }

    public ResultSet(Iterable<Entity> results, Pagination pagination) {
        
        this.results = ImmutableList.copyOf(results);
        this.pagination = pagination;
    }

    public ImmutableList<Entity> getResults()
    {
        return this.results;
    }
    
    public int size()
    {
	return this.results.size();
    }

    public long getTotalResultsSize()
    {
        return this.pagination.getTotalResultsSize();
    }

    public long getBatchSize()
    {
        return this.pagination.getBatchSize();
    }

    public long getBatchIndex()
    {
        return this.pagination.getBatchIndex();
    }

    public Iterator<Entity> iterator()
    {
        return results.iterator();
    }

    public String getResultType() {
	return resultType;
    }

    public void setResultType(String resultType) {
	this.resultType = resultType;
    }

/*   
    @JsonIgnore
    public Entity getFirst()
    {
        return results.first();
    }


    @JsonIgnore
    public Entity getLast()
    {
        return results.last();
    }



    @Override
    public boolean containsAllIterable(Iterable<?> source)
    {
        return results.containsAllIterable(source);
    }

    @Override
    public boolean containsAll(Collection<?> source)
    {
        return results.containsAll(source);
    }

    @Override
    public boolean containsAllArguments(Object... elements)
    {
        return results.containsAllArguments(elements);
    }

    @Override
    public RichIterable<Entity> filter(Predicate<? super Entity> predicate)
    {
        return results.filter(predicate);
    }

    @Override
    public RichIterable<Entity> filterNot(Predicate<? super Entity> predicate)
    {
        return results.filterNot(predicate);
    }

    @Override
    public PartitionIterable<Entity> partition(Predicate<? super Entity> predicate)
    {
        return results.partition(predicate);
    }

    @Override
    public <V> RichIterable<V> transform(Function<? super Entity, ? extends V> function)
    {
        return results.transform(function);
    }

    @Override
    public <V, R extends Collection<V>> R transform(Function<? super Entity, ? extends V> function, R target)
    {
        return results.transform(function, target);
    }

    @Override
    public <P, V, R extends Collection<V>> R transformWith(Function2<? super Entity, ? super P, ? extends V> function, P parameter, R targetCollection)
    {
        return results.transformWith(function, parameter, targetCollection);
    }

    @Override
    public <V> RichIterable<V> transformIf(Predicate<? super Entity> predicate, Function<? super Entity, ? extends V> function)
    {
        return results.transformIf(predicate, function);
    }

    @Override
    public <V, R extends Collection<V>> R transformIf(Predicate<? super Entity> predicate, Function<? super Entity, ? extends V> function, R target)
    {
        return results.transformIf(predicate, function, target);
    }

    @Override
    public <V> RichIterable<V> flatTransform(Function<? super Entity, ? extends Iterable<V>> function)
    {
        return results.flatTransform(function);
    }

    @Override
    public <V, R extends Collection<V>> R flatTransform(Function<? super Entity, ? extends Iterable<V>> function, R target)
    {
        return results.flatTransform(function, target);
    }

    @Override
    public Entity find(Predicate<? super Entity> predicate)
    {
        return results.find(predicate);
    }

    @Override
    public Entity findIfNone(Predicate<? super Entity> predicate, Function0<? extends Entity> function)
    {
        return results.findIfNone(predicate, function);
    }

    @Override
    public int count(Predicate<? super Entity> predicate)
    {
        return results.count(predicate);
    }

    @Override
    public boolean anySatisfy(Predicate<? super Entity> predicate)
    {
        return results.anySatisfy(predicate);
    }

    @Override
    public boolean allSatisfy(Predicate<? super Entity> predicate)
    {
        return results.allSatisfy(predicate);
    }

    @Override
    public <IV> IV foldLeft(IV initialValue, Function2<? super IV, ? super Entity, ? extends IV> function)
    {
        return results.foldLeft(initialValue, function);
    }

    @Override
    public int foldLeft(int initialValue, IntObjectToIntFunction<? super Entity> intObjectToIntFunction)
    {
        return results.foldLeft(initialValue, intObjectToIntFunction);
    }

    @Override
    public long foldLeft(long initialValue, LongObjectToLongFunction<? super Entity> longObjectToLongFunction)
    {
        return results.foldLeft(initialValue, longObjectToLongFunction);
    }

    @Override
    public double foldLeft(double initialValue, DoubleObjectToDoubleFunction<? super Entity> doubleObjectToDoubleFunction)
    {
        return results.foldLeft(initialValue, doubleObjectToDoubleFunction);
    }

    @Override
    public MutableList<Entity> toList()
    {
        return results.toList();
    }

    @Override
    public MutableList<Entity> toSortedList()
    {
        return results.toSortedList();
    }

    @Override
    public MutableList<Entity> toSortedList(Comparator<? super Entity> comparator)
    {
        return results.toSortedList(comparator);
    }

    @Override
    public <V extends Comparable<? super V>> MutableList<Entity> toSortedListBy(Function<? super Entity, ? extends V> function)
    {
        return results.toSortedListBy(function);
    }

    @Override
    public MutableSet<Entity> toSet()
    {
        return results.toSet();
    }

    @Override
    public MutableSortedSet<Entity> toSortedSet()
    {
        return results.toSortedSet();
    }

    @Override
    public MutableSortedSet<Entity> toSortedSet(Comparator<? super Entity> comparator)
    {
        return results.toSortedSet(comparator);
    }

    @Override
    public <V extends Comparable<? super V>> MutableSortedSet<Entity> toSortedSetBy(Function<? super Entity, ? extends V> function)
    {
        return results.toSortedSetBy(function);
    }

    @Override
    public MutableBag<Entity> toBag()
    {
        return results.toBag();
    }

    @Override
    public <NK, NV> MutableMap<NK, NV> toMap(Function<? super Entity, ? extends NK> keyFunction, Function<? super Entity, ? extends NV> valueFunction)
    {
        return results.toMap(keyFunction, valueFunction);
    }

    @Override
    public <NK, NV> MutableSortedMap<NK, NV> toSortedMap(Function<? super Entity, ? extends NK> keyFunction, Function<? super Entity, ? extends NV> valueFunction)
    {
        return results.toSortedMap(keyFunction, valueFunction);
    }

    @Override
    public <NK, NV> MutableSortedMap<NK, NV> toSortedMap(Comparator<? super NK> comparator, Function<? super Entity, ? extends NK> keyFunction, Function<? super Entity, ? extends NV> valueFunction)
    {
        return results.toSortedMap(comparator, keyFunction, valueFunction);
    }

    @Override
    public LazyIterable<Entity> asLazy()
    {
        return results.asLazy();
    }

    @Override
    public Object[] toArray()
    {
        return results.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a)
    {
        return results.toArray(a);
    }

    @Override
    public Entity min(Comparator<? super Entity> comparator)
    {
        return results.min(comparator);
    }

    @Override
    public Entity max(Comparator<? super Entity> comparator)
    {
        return results.max(comparator);
    }

    @Override
    public Entity min()
    {
        return results.min();
    }

    @Override
    public Entity max()
    {
        return results.max();
    }

    @Override
    public <V extends Comparable<? super V>> Entity minBy(Function<? super Entity, ? extends V> function)
    {
        return results.minBy(function);
    }

    @Override
    public <V extends Comparable<? super V>> Entity maxBy(Function<? super Entity, ? extends V> function)
    {
        return results.maxBy(function);
    }

    @Override
    public String makeString()
    {
        return results.makeString();
    }

    @Override
    public String makeString(String separator)
    {
        return results.makeString(separator);
    }

    @Override
    public String makeString(String start, String separator, String end)
    {
        return results.makeString(start, separator, end);
    }

    @Override
    public void appendString(Appendable appendable)
    {
        results.appendString(appendable);
    }

    @Override
    public void appendString(Appendable appendable, String separator)
    {
        results.appendString(appendable, separator);
    }

    @Override
    public void appendString(Appendable appendable, String start, String separator, String end)
    {
        results.appendString(appendable, start, separator, end);
    }

    @Override
    public <V> Multimap<V, Entity> groupBy(Function<? super Entity, ? extends V> function)
    {
        return results.groupBy(function);
    }

    @Override
    public <V> Multimap<V, Entity> groupByEach(Function<? super Entity, ? extends Iterable<V>> function)
    {
        return results.groupByEach(function);
    }

    @Override
    public <S> RichIterable<Pair<Entity, S>> zip(Iterable<S> that)
    {
        return results.zip(that);
    }

    @Override
    public RichIterable<Pair<Entity, Integer>> zipWithIndex()
    {
        return results.zipWithIndex();
    }

    @Override
    public RichIterable<RichIterable<Entity>> chunk(int size)
    {
        return results.chunk(size);
    }

    @Override
    public <R extends Collection<Pair<Entity, Integer>>> R zipWithIndex(R target)
    {
        return results.zipWithIndex(target);
    }

    @Override
    public <S, R extends Collection<Pair<Entity, S>>> R zip(Iterable<S> that, R target)
    {
        return results.zip(that, target);
    }

    @Override
    public <V, R extends MutableMultimap<V, Entity>> R groupByEach(Function<? super Entity, ? extends Iterable<V>> function, R target)
    {
        return results.groupByEach(function, target);
    }

    @Override
    public <V, R extends MutableMultimap<V, Entity>> R groupBy(Function<? super Entity, ? extends V> function, R target)
    {
        return results.groupBy(function, target);
    }

    @Override
    public <P, R extends Collection<Entity>> R filterNotWith(Predicate2<? super Entity, ? super P> predicate, P parameter, R targetCollection)
    {
        return results.filterNotWith(predicate, parameter, targetCollection);
    }

    @Override
    public <R extends Collection<Entity>> R filterNot(Predicate<? super Entity> predicate, R target)
    {
        return results.filterNot(predicate, target);
    }

    @Override
    public <P, R extends Collection<Entity>> R filterWith(Predicate2<? super Entity, ? super P> predicate, P parameter, R targetCollection)
    {
        return results.filterWith(predicate, parameter, targetCollection);
    }

    @Override
    public <R extends Collection<Entity>> R filter(Predicate<? super Entity> predicate, R target)
    {
        return results.filter(predicate, target);
    }

    @Override
    public void forEach(Procedure<? super Entity> procedure)
    {
        results.forEach(procedure);
    }

    @Override
    public void forEachWithIndex(ObjectIntProcedure<? super Entity> objectIntProcedure)
    {
        results.forEachWithIndex(objectIntProcedure);
    }

    @Override
    public <P> void forEachWith(Procedure2<? super Entity, ? super P> procedure, P parameter)
    {
        results.forEachWith(procedure, parameter);
    }
*/
    

}
